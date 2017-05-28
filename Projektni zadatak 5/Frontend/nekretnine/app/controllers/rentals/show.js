import Ember from 'ember';

export default Ember.Controller.extend({
  session: Ember.inject.service(),
  rentalService: Ember.inject.service()

});
