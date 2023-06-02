var db = connect("mongodb://root:pestillo@localhost:27017/admin");

db = db.getSiblingDB('tattooer-images'); // we can not use "use" statement here to switch db

db.createUser(
    {
        user: "wasu",
        pwd: "pestillo",
        roles: [ { role: "readWrite", db: "tattooer-images"} ],
    }
)