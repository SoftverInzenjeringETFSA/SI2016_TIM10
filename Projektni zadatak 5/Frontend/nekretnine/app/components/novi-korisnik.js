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
		if(this.get('korisnik.korisnickoIme')==='' || this.get('korisnik.korisnickoIme')===undefined){
			this.get('errors').add('korisnickoIme','Unesite username!!');
		}
		if(this.get('korisnik.sifra')==='' || this.get('korisnik.sifra')===undefined){
			this.get('errors').add('sifra','Unesite password!!');
		}
		if(this.get('korisnik.email')==='' || this.get('korisnik.eMail')===undefined){
			this.get('errors').add('eMail','Unesite email!!');
		}
		
		return this.get('errors.isEmpty');
	}, 
    
    actions:{
		submit:function(){
		if(this.validate()){
        this.sendAction('action',this.korisnik);
            console.log(this.korisnik);
            //this.get('accountService').register(registerData);
            
            }
		}
	},
});
