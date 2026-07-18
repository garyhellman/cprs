Ext.define('CPRS.controller.Quakes', {
    extend: 'Ext.app.Controller',
    stores: [
             'Quakes'
            ],
    models: [
             'Quake'
            ],

    views: [
            'quake.List',
            'quake.Edit'
        ],
	
    init: function() {
        console.log('Initialized Quakes! This happens before the Application launch function is called');
        this.control({
        	'quakelist': {
        		itemdblclick: this.editQuake
            },
            'quakeedit button[action=save]': {
            	click: this.updateQuake
            }
        });
        
        console.log('Quakes! About to do store load');
        // trigger the data store load
        //this.store.load();     
        //this.getQuakesStore().load();
    },
    
//  onPanelRendered: function() {
//  console.log('The panel was rendered');
//}

editQuake: function(grid, record) {
	console.log('Double clicked on ' + record.get('schoolname'));
//	var view = Ext.widget('schooledit');
//	
//	view.down('form').loadRecord(record);
},
updateQuake: function(button) {
	console.log('clicked the save button ') ;
//	var win = button.up('window'),
//	form = win.down('form'),
//	record = form.getRecord(),
//	values = form.getValues();
//	
//	record.set(values);
//	win.close();
//	
//	this.getSchoolsStore().sync();
}

    
    	
});



// trigger the data store load
//store.load();

