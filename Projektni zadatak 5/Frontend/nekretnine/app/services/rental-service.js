import Ember from 'ember';

import BaseService from './base-service';

export default BaseService.extend({
    all: function() {
        var rentals = []; // ovdje prazan objekat
        this.ajax({ url: "http://localhost:8080/oglasi/all", type: "GET" }).then(function(data) {
            data.forEach(function(rental) {
                rentals.addObject(rental);
            });
        });
        return rentals;
    },

    getById: function(id) {
        var rental = Ember.Object.create({});
        this.ajax({ url: "http://localhost:8080/oglasi/one/"+id, type: "GET"}).then(function(data) {
        	console.log("data: ");
        	console.log(data);
          	console.log("created: ");
        	console.log(rental);
            rental.setProperties(data);
        });

        return rental;
    },
  register: function(data) {
    return this.ajax({ url: "http://localhost:8080/oglasi/create", type: "POST", data: JSON.stringify(data)})
  }
});
