Ext.define('CPRS.controller.Schools', {
    extend: 'Ext.app.Controller',
    stores: [
             'Schools'
            ],
    models: [
             'School'
            ],

    views: [
            'school.List',
            'school.Edit'
        ],
    
    init: function() {
        console.log('Initialized Schools! This happens before the Application launch function is called');
        this.control({
        	'schoollist': {
        		itemdblclick: this.editSchool
            },
            'schooledit button[action=save]': {
            	click: this.updateSchool
            }
        });
    },

//    onPanelRendered: function() {
//        console.log('The panel was rendered');
//    }

	editSchool: function(grid, record) {
		console.log('Double clicked on ' + record.get('schoolname'));
		var view = Ext.widget('schooledit');
		
		view.down('form').loadRecord(record);
	},
	updateSchool: function(button) {
		console.log('clicked the save button ') ;
		var win = button.up('window'),
		form = win.down('form'),
		record = form.getRecord(),
		values = form.getValues();
		
		record.set(values);
		win.close();
		
		this.getSchoolsStore().sync();
	}
	
});