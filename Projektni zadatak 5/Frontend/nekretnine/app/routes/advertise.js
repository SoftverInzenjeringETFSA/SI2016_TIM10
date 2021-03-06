import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Route.extend({
  rentalService: Ember.inject.service(),
  session: Ember.inject.service(),


  model: function(){
    console.log(this.get('session.data.authenticated.korisnik.id'));
  return{korisnik:this.get('session.data.authenticated.korisnik'),nazivOglasa:'',vrstaOglasa:'',vrstaNekretnine:'', adresa:'',grad:'',kvadratura:'',cijena:'',brojProstorija:'',brojSpratova:'',datumObjave:Date.now(),slika:''};
  },
  setupController:function(controller,model){
    controller.set('oglas',model);
  },
  actions:{

    createOglas:function(oglas){
      console.log(oglas);
      var emberObject = Ember.Object.create();
      emberObject = this.get('session.data.authenticated.korisnik');
      console.log("Broj objava:");
      console.log(emberObject.brojObjava);
      var broj = emberObject.brojObjava;
      broj = broj+1;
      console.log(broj);
      oglas.korisnik = emberObject;
      console.log("Oglas koji kreiram:");
      console.log(oglas);
      this.get('rentalService').register(oglas);


    }
  }
});
