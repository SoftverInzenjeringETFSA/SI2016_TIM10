import Ember from 'ember';

export default Ember.Route.extend({
	rentalService: Ember.inject.service(), // ovo automatski injecta onaj ranije kreirani accountService

     model: function(params) {
        return Ember.RSVP.hash({
            rental: this.get('rentalService').getById(params.id)
            
        });
    }
});
