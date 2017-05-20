import Ember from 'ember';

export default Ember.Route.extend({
	accountService: Ember.inject.service(), // ovo automatski injecta onaj ranije kreirani accountService

     model: function(params) {
        return Ember.RSVP.hash({
            account: this.get('accountService').getById(params.id)
            
        });
    }
});
