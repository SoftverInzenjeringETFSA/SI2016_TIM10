import Ember from 'ember';

export default Ember.Route.extend({
 session: Ember.inject.service(),
	rentalService: Ember.inject.service(),

     model: function(params) {
       let br = this.get('rentalService').vecZainteresovan(this.get('session.data.authenticated.korisnik.id'), params.id);
        return Ember.RSVP.hash({
            rental: this.get('rentalService').getById(params.id),
						zainteresovaniK: this.get('rentalService').getZainteresovani(params.id),
            sviZainteresovani: this.get('rentalService').sviZainteresovani(),
            vecZaint: br
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
  var idk =this.get('session.data.authenticated.korisnik.id');
  var ido = this.controller.get('model.rental.id');

  //var ima = this.get('rentalService').vecZainteresovan(idk, ido);

    console.log(zk);
    this.get('rentalService').zainteresovanKorisnik(zk);
  	alert('Zainteresovani ste!');
    //document.getElementById('ZK').style.visibility = 'hidden';
    window.location.reload();





	},
  nezainteresovan:function(){

  var idk =this.get('session.data.authenticated.korisnik.id');
  var ido = this.controller.get('model.rental.id');


    this.get('rentalService').neZainteresujSe(idk, ido);
  	alert('Nezaainteresovani ste!');
    //document.getElementById('ZK').style.visibility = 'hidden';
    window.location.reload();


	}
		}


});
