Ext.define('CPRS.store.Schools' ,{
    extend: 'Ext.data.Store',
    model: 'CPRS.model.School',
    autoLoad: true,
    
    proxy: {
    	type: 'ajax',
    	api: {
        	read: 'data/schools.json',
        	update: 'data/updateSchools.json'
    	},
    	reader: {
    		type: 'json',
    		root: 'schools',
    		successProperty: 'success'
    	}
    }
});
