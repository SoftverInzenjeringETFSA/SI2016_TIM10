import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Route.extend({
  rentalService: Ember.inject.service(),

  model: function(){
    return{nazivOglasa:'',vrstaOglasa:'',vrstaNekretnine:'', adresa:'',grad:'',kvadratura:'',cijena:'',brojProstorija:'',brojSpratova:'',datumObjave:Date.now()};
  },
  setupController:function(controller,model){
    controller.set('oglas',model);
  },
  actions:{
    createOglas:function(oglas){
      console.log(oglas);
      this.get('rentalService').register(oglas);


    }
  }
});
