import Ember from 'ember';

export default Ember.Route.extend({
 rentalService: Ember.inject.service(),

  model: function() {
    return Ember.RSVP.hash({
      rentals: this.get('rentalService').all()
    });
  },

  setupController:function(controller, model){
    controller.set('rental', model);
  },
});
