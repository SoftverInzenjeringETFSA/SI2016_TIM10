import Ember from 'ember';

export default Ember.Controller.extend({
    session: Ember.inject.service(),

    model: {},
    errorMessage: '',

    actions: {
        login() {
            this.get('session').authenticate('authenticator:application', this.model, (data) => {
                    console.log(data);
                    Ember.set(this, 'errorMessage', '');
                    Ember.set(this, 'model', {});
                    console.log(data.korisnik.id);
                    this.transitionToRoute('profile');
                })
                .catch(reason => {
                    Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
				    this.set('authenticationError', this.errorMessage || reason);
			    });
        }
    }

});
