import Ember from 'ember';
import DS from 'ember-data';


export default Ember.Component.extend({
  accountService: Ember.inject.service(),
  errors:DS.Errors.create(),



  validate: function(){
    this.set('errors',DS.Errors.create());


    if(this.get('korisnik.korisnickoIme')==='' || this.get('korisnik.korisnickoIme')===undefined){
      this.get('errors').add('korisnickoIme','Unesite username!!');
    }
    if(this.get('korisnik.sifra')==='' || this.get('korisnik.sifra')===undefined){
      this.get('errors').add('sifra','Unesite password!!');
    }

    return this.get('errors.isEmpty');
  },

  actions:{
    login:function(){
      if(this.validate()){
        this.sendAction('action',this.korisnik);
        this.get('accountService').login(this.korisnik);
      }
    }
  },
});
