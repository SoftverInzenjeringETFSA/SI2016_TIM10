import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('about');
  this.route('rentals', function() {
  this.route('show', { path: '/:id' });  });
  this.route('login');
  this.route('register');
  this.route('accounts', function() {
    this.route('show', { path: '/:id' });  });
  this.route('advertise');
 
});

export default Router;
