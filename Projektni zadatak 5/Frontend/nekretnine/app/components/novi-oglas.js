import Ember from 'ember';
import DS from 'ember-data';


export default Ember.Component.extend({
    accountService: Ember.inject.service(),
    errors:DS.Errors.create(),



    validate: function(){
        this.set('errors',DS.Errors.create());

        if(this.get('oglas.nazivOglasa')==='' || this.get('oglas.nazivOglasa')===undefined){
            this.get('errors').add('nazivOglasa','Unesite naziv!!');
        }
        if(this.get('oglas.vrstaOglasa')==='' || this.get('oglas.vrstaOglasa')===undefined){
            this.get('errors').add('vrstaOglasa','Unesite vrstu oglasa!!');
        }
        if(this.get('oglas.vrstaNekretnine')==='' || this.get('oglas.vrstaNekretnine')===undefined){
            this.get('errors').add('vrstaNekretnine','Unesite vrstu nekretnine!!');
        }
        if(this.get('oglas.adresa')==='' || this.get('oglas.adresa')===undefined){
            this.get('errors').add('adresa','Unesite adresu!!');
        }
        if(this.get('oglas.grad')==='' || this.get('oglas.grad')===undefined){
            this.get('errors').add('grad','Unesite grad!!');
        }

        if(this.get('oglas.kvadratura')==='' || this.get('oglas.kvadratura')===undefined){
            this.get('errors').add('kvadratura','Unesite kvadraturu!!');
        }
        if(this.get('oglas.cijena')==='' || this.get('oglas.cijena')===undefined){
            this.get('errors').add('cijena','Unesite cijenu!!');
        }

        if(this.get('oglas.brojProstorija')==='' || this.get('oglas.brojProstorija')===undefined){
            this.get('errors').add('brojProstorija','Unesite broj prostorija!!');
        }
        if(this.get('oglas.brojSpratova')==='' || this.get('oglas.brojSpratova')===undefined){
            this.get('errors').add('brojSpratova','Unesite broj spratova!!');
        }
        return this.get('errors.isEmpty');
    },

    actions:{
        submit:function(){
            if(this.validate()){
                this.sendAction('action',this.oglas);
                console.log(this.oglas);
                //this.get('accountService').register(registerData);

            }
        }
    },
});
