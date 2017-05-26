import Ember from 'ember';

export default Ember.Route.extend({
  rentalService: Ember.inject.service(),
  session: Ember.inject.service(),
  model: function() {
    console.log(this.get('session.data.authenticated.korisnik.id'));
     return Ember.RSVP.hash({
         rentals: this.get('rentalService').getOglasibyUserid(this.get('session.data.authenticated.korisnik.id'))
     });
 }
});
