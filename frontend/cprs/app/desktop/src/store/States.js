Ext.define('CPRS.store.States' ,{
    extend: 'Ext.data.Store',
    model: 'CPRS.model.State',
    autoLoad: true,
    
    proxy: {
    	type: 'ajax',
    	api: {
        	read: 'data/states.json',
        	update: 'data/updateStates.json'
    	},
    	reader: {
    		type: 'json',
    		root: 'states',
    		successProperty: 'success'
    	}
    }
});
