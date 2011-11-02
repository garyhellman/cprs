Ext.define('CPRS.controller.States', {
    extend: 'Ext.app.Controller',
    stores: [
             'States'
            ],
    models: [
             'State'
            ],

    views: [
            'state.List',
            'state.Edit'
        ],
    
    init: function() {
        console.log('Initialized States! This happens before the Application launch function is called');
        this.control({
        	'statelist': {
        		itemdblclick: this.editState
            },
            'stateedit button[action=save]': {
            	click: this.updateState
            }
        });
    },

//    onPanelRendered: function() {
//        console.log('The panel was rendered');
//    }

	editState: function(grid, record) {
		console.log('Double clicked on ' + record.get('statename'));
		var view = Ext.widget('stateedit');
		
		view.down('form').loadRecord(record);
	},
	updateState: function(button) {
		console.log('clicked the save button ') ;
		var win = button.up('window'),
		form = win.down('form'),
		record = form.getRecord(),
		values = form.getValues();
		
		record.set(values);
		win.close();
		
		this.getStatesStore().sync();
	}
	
});