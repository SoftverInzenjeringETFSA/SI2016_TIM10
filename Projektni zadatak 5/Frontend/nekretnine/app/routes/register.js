import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Route.extend({
accountService: Ember.inject.service(),
    
	model: function(){
		return{ime:'',prezime:'',korisnickoIme:'',sifra:'',eMail:''};
	},
	setupController:function(controller,model){
		controller.set('korisnik',model);
	},
	actions:{
		createKorisnik:function(korisnik){
            console.log(korisnik);
            this.get('accountService').register(korisnik);
  
            
		}
	}
});
