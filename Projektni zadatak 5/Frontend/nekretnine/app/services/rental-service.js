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
    console.log("ID korisnika");
    console.log(data.korisnik.id);
    this.ajax({ url: "http://localhost:8080/korisnici/update?id="+data.korisnik.id, type: "POST"})
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
    getBrojObjava: function(id){
      var brojObjava=Ember.Object.create();
      this.ajax({ url: "http://localhost:8080/korisnici/brojObjava?id="+id, type: "GET"}).then(function(data) {
      console.log("data: ");
      console.log(data);
        console.log("created: ");
        brojObjava.set("broj" ,data);
        console.log(brojObjava);
    });
    return brojObjava;
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
    //kreira ZK
    zainteresovanKorisnik:function(data){
    return this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/create" ,type: "POST", data: JSON.stringify(data)})
  },

//korisnici zainteresovani za odjedjeni oglas
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
  },

  sviZainteresovani: function(){
    var zainteresovani = []; // ovdje prazan objekat
    this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/all", type: "GET" }).then(function(data) {
        data.forEach(function(z) {
            zainteresovani.addObject(z);
        });
    });
    return zainteresovani;
  },

vecZainteresovan: function(idk, ido){
  var broj=Ember.Object.create();
  this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/zainteresovan?idk="+idk+'&ido='+ido, type: "GET"}).then(function(data) {
  console.log("data: ");
  console.log(data);
    console.log("created: ");
    broj.set("br" ,data);
    console.log(broj);
});
 return broj;
},

neZainteresujSe: function(idk, ido) {
  return this.ajax({ url: "http://localhost:8080/zainteresovaniKorisnici/deletezkk?idk="+idk+'&ido='+ido, type: "POST"})
}

});
