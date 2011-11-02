Ext.require(['Ext.data.*', 'Ext.grid.*']);

Ext.define('CPRS.controller.Persons', {
    extend: 'Ext.app.Controller',

	views: [ 'person.List' ],
	refs: [ {
		ref: 'personList',
		selector: 'personlist'
	}],
    
    init: function() {
        console.log('Initialized Persons! This happens before the Application launch function is called');
    }
	
	
});