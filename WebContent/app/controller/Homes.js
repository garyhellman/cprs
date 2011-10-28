Ext.define('CPRS.controller.Homes', {
    extend: 'Ext.app.Controller',

	views: [ 'home.List' ],
	refs: [ {
		ref: 'homeList',
		selector: 'homelist'
	}],
    
    init: function() {
        console.log('Initialized Homes! This happens before the Application launch function is called');
    }
});