import Ember from 'ember';

export default Ember.Route.extend({
  rentalService: Ember.inject.service(),
  session: Ember.inject.service(),
  accountService: Ember.inject.service(),

  model: function() {
  let bO =this.get('rentalService').getBrojOglasaKorisnika(this.get('session.data.authenticated.korisnik.id'));

    console.log(this.get('session.data.authenticated.korisnik.id'));
     return Ember.RSVP.hash({
         rentals: this.get('rentalService').getOglasibyUserid(this.get('session.data.authenticated.korisnik.id')),
         brojOglasa: bO

     });
 },


 actions:{
   deleteProfile:function(){
    var x = window.confirm("Obrisite profil?");
    if (x == true) {
    this.get('rentalService').deleteOglasibyID(this.get('session.data.authenticated.korisnik.id'));
    this.get('accountService').deletebyID(this.get('session.data.authenticated.korisnik.id'));
    this.get('session').invalidate();
    this.transitionTo('login');
} else {

}

 },
 provjera: function(){
   console.log('dgfgdf');
 }
 }
});
