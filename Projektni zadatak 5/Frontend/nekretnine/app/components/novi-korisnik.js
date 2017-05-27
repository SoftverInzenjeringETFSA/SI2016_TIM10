import Ember from 'ember';
import DS from 'ember-data';


export default Ember.Component.extend({
accountService: Ember.inject.service(),
	errors:DS.Errors.create(),



	validate: function(){
		let regpassword = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    let regime=/^[A-Z][a-z_-]{2,19}$/;
    let regemail=/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		this.set('errors',DS.Errors.create());

		if(this.get('korisnik.ime')==='' || this.get('korisnik.ime')===undefined || !this.get('korisnik.ime').match(regime)){
			this.get('errors').add('ime','Ime mora počinjati sa velikim slovom i ne smije sadržavati brojeve!!');
		}
		if(this.get('korisnik.prezime')==='' || this.get('korisnik.prezime')===undefined || !this.get('korisnik.prezime').match(regime)){
			this.get('errors').add('prezime','Prezime mora počinjati sa velikim slovom i ne smije sadržavati brojeve!!');
		}
		if(this.get('korisnik.korisnickoIme')==='' || this.get('korisnik.korisnickoIme')===undefined){
			this.get('errors').add('korisnickoIme','Unesite username!!');
		}
		if(this.get('korisnik.sifra')==='' || this.get('korisnik.sifra').length < 8 ||  !this.get('korisnik.sifra').match(regpassword) ){
			this.get('errors').add('sifra','Password mora sadržavati najmanje 8 znakova i  barem jedno veliko slovo i broj!');
		}
		if(this.get('korisnik.eMail')==='' || this.get('korisnik.eMail')===undefined || !this.get('korisnik.eMail').match(regemail)){
			this.get('errors').add('eMail','e-mail mora biti u formatu: example@example.com !!');
		}
		
		return this.get('errors.isEmpty');
	},

    actions:{
		submit:function(){
		if(this.validate()){
        this.sendAction('action',this.korisnik);
            console.log(this.korisnik);
					alert("Kreiran racun!");
					this.set('korisnik', '');

            //this.get('accountService').register(registerData);

            }
						
		}
	},
});
