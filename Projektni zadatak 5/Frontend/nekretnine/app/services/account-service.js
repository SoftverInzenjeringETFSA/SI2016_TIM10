import Ember from 'ember';
import BaseService from './base-service';

export default BaseService.extend({
    all: function() {
        var accounts = []; // ovdje prazan objekat
        this.ajax({ url: "http://localhost:8080/korisnici/all", type: "GET" }).then(function(data) {
            data.forEach(function(account) {
                accounts.addObject(account);
            });
        });
        return accounts;
    },

    getById: function(id) {
        var account = Ember.Object.create({});
        this.ajax({ url: "http://localhost:8080/korisnici/one/"+id, type: "GET"}).then(function(data) {
            account.setProperties(data);
        });

        return account;
    },

  register: function(data) {
        return this.ajax({ url: "http://localhost:8080/korisnici/create", type: "POST", data: JSON.stringify(data)})
    },

  login: function(data) {
      console.log(data);
    return this.ajax({url: "http://localhost:8080/korisnici/login", type: "POST", data: JSON.stringify(data)})
  }

});
