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
  },

  getOglasibyUserid: function(id) {
        var rentals = [];
        this.ajax({ url: "http://localhost:8080/oglasi/allOglasiKorisnik?id="+id, type: "GET" }).then(function(data) {
            data.forEach(function(rental) {
                rentals.addObject(rental);
            });
        });
        return rentals;
    },

    deleteOglasibyID: function(id){
        return this.ajax({ url: "http://localhost:8080/oglasi/deleteOglasi?id="+id, type: "POST"})
    },

//nece ne znam ovo popraviti, nece da mi objekat kreira vec class
    getBrojOglasaKorisnika:function(id){
        var brojOglasa=Ember.Object.create();
        this.ajax({ url: "http://localhost:8080/oglasi/brojOglasa?id="+id, type: "GET"}).then(function(data) {
        console.log("data: ");
        console.log(data);
          console.log("created: ");
          brojOglasa.set("broj" ,data);
          console.log(brojOglasa);
      });
      return brojOglasa;
    },

    deleteOglas:function(id){
        return this.ajax({ url: "http://localhost:8080/oglasi/delete/"+id, type: "POST"})
    },
    zainteresovanKorisnik:function(data){
    return this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/create" ,type: "POST", data: JSON.stringify(data)})
  },

  getZainteresovani: function(id){
    var zk = []; // ovdje prazan objekat
    this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/allZKOglas?id="+id, type: "GET" }).then(function(data) {
        data.forEach(function(z) {
            zk.addObject(z);
        });
    });
    return zk;
  },
  deleteZKbyUserID:function(id){
      return this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/deleteZK?id="+id, type: "POST"})
  }

});
