import Ember from 'ember';
import DS from 'ember-data';
export default Ember.Route.extend({
	model: function(){
		return{ime:'',prezime:'',username:'',password:'',email:''};
	},
	setupController:function(controller,model){
		controller.set('korisnik',model);
	},
	actions:{
		createKorisnik:function(korisnik){
console.log(korisnik);



		}
	}
});
