Ext.define('CPRS.store.Persons', {
	extend: 'Ext.data.Store',
	model: 'CPRS.model.Person',
    autoLoad: true,
    autoSync: true,
        proxy: {
            type: 'rest',
            url: 'app.php/users',
            reader: {
                type: 'json',
                root: 'data'
            },
            writer: {
                type: 'json'
            }
        },

        listeners: {
            write: function(store, operation){
                var record = operation.getRecords()[0],
                    name = Ext.String.capitalize(operation.action),
                    verb;
                    
                    
                if (name == 'Destroy') {
                    record = operation.records[0];
                    verb = 'Destroyed';
                } else {
                    verb = name + 'd';
                }
                Ext.example.msg(name, Ext.String.format("{0} user: {1}", verb, record.getId()));
                
            }
        }
    

});