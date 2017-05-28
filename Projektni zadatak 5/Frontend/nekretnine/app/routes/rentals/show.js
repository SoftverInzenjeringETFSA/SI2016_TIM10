import Ember from 'ember';

export default Ember.Route.extend({
 session: Ember.inject.service(),
	rentalService: Ember.inject.service(),

     model: function(params) {
        return Ember.RSVP.hash({
            rental: this.get('rentalService').getById(params.id),
						zainteresovaniK: this.get('rentalService').getZainteresovani(params.id)
        });
    },

		actions:{
			delete:function(){
				var vlasnik= this.get('session.data.authenticated.korisnik.id');
				var rental= this.controller.get('model.rental');
				console.log('vlasnik:');
				console.log(vlasnik);
				if(vlasnik == rental.korisnik.id){
					var x = window.confirm("Obrisite oglas?");
			    if (x == true) {
				console.log(rental.id);
			this.get('rentalService').deleteOglas(rental.id);
			console.log('brisem');
			alert('Oglas obrisan!');
			this.transitionTo('rentals');			}

		}
		else{console.log('niste vlasnik'); alert('Niste vlasnik oglasa!');}
	},
	zainteresovan:function(){
	var zk= Ember.Object.create();
	var vlasnik= this.get('session.data.authenticated.korisnik');
	var rental= this.controller.get('model.rental');
	zk.set('korisnik',vlasnik);
	zk.set('oglas', rental);
	console.log(zk);
	this.get('rentalService').zainteresovanKorisnik(zk);
	alert('Zainteresovani ste!');
	document.getElementById("ZK").disabled = true;
	}
		}


});
