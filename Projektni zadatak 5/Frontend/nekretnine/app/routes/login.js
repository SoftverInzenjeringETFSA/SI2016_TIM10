import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Route.extend({
  accountService: Ember.inject.service(),

  model: function(){
    return{korisnickoIme:'',sifra:''};
  },
  setupController:function(controller, model){
    controller.set('korisnik', model);
  },
  actions:{
    login:function(korisnik){
      console.log(korisnik);
      this.get('accountService').login(korisnik);
    }
  }
});
