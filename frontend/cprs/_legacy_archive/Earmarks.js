Ext.define('EarmarkApp.controller.Earmarks', {
    extend: 'Ext.app.Controller',
	stores: ['Earmarks','Sponsors','SpendingCommittees'],
    models: ['Earmark','Sponsor','SpendingCommittee'],
    views: ['earmark.List', 'earmark.Edit'],
	
	init: function() {
        this.control({
            'earmarklist': {
                itemdblclick: this.editEarmark
            },
			'earmarkedit button[action=save]': {
                click: this.updateEarmark
            }
			
        });
    },

    editEarmark: function(grid,record) {
        var edit = Ext.create('EarmarkApp.view.earmark.Edit').show();
        edit.down('form').loadRecord(record);
    },
	
	updateEarmark: function(button) {
		 var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
		
		/* insert data commit / post to app server code here */
		
	}
});