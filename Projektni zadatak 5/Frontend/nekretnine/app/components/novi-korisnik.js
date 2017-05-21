import Ember from 'ember';
import DS from 'ember-data';


export default Ember.Component.extend({
accountService: Ember.inject.service(),
	errors:DS.Errors.create(),
	
    
	
	validate: function(){
		this.set('errors',DS.Errors.create());

		if(this.get('korisnik.ime')==='' || this.get('korisnik.ime')===undefined){
			this.get('errors').add('ime','Unesite ime!!');
		}
		if(this.get('korisnik.prezime')==='' || this.get('korisnik.prezime')===undefined){
			this.get('errors').add('prezime','Unesite prezime!!');
		}
		if(this.get('korisnik.username')==='' || this.get('korisnik.username')===undefined){
			this.get('errors').add('username','Unesite username!!');
		}
		if(this.get('korisnik.password')==='' || this.get('korisnik.password')===undefined){
			this.get('errors').add('password','Unesite password!!');
		}
		if(this.get('korisnik.email')==='' || this.get('korisnik.email')===undefined){
			this.get('errors').add('email','Unesite email!!');
		}
		
		return this.get('errors.isEmpty');
	},
    
    actions:{
		submit:function(){
			if(this.validate()){
            this.sendAction('action',this.korisnik);
            
            }
		}
	},
});
