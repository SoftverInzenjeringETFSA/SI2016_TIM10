import Ember from 'ember';

export default Ember.Route.extend({
 session: Ember.inject.service(),
	rentalService: Ember.inject.service(),

     model: function(params) {
        return Ember.RSVP.hash({
            rental: this.get('rentalService').getById(params.id)

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
			transitionTo('rentals');
		}

		}
		else{console.log('niste vlasnik'); alert('Niste vlasnik oglasa!');}
			}
		}
});
