Ext.define('CPRS.controller.AcadInstitutions', {
    extend: 'Ext.app.Controller',

    stores: ['AcadInstitutions'],

    models: ['AcadInstitution'],

    views: ['acadinstitution.Edit', 'acadinstitution.List'],

    refs: [{
            ref: 'acadinstitutionsPanel',
            selector: 'panel'
        },{
            ref: 'acadinstitutionlist',
            selector: 'acadinstitutionlist'
        }
    ],

    init: function() {
        this.control({
            'acadinstitutionlist dataview': {
                itemdblclick: this.editInstitution
            },
            'acadinstitutionlist button[action=add]': {
            	click: this.editInstitution
            },
            'acadinstitutionlist button[action=delete]': {
                click: this.deleteInstitution
            },
            'acadinstitutionedit button[action=save]': {
                click: this.updateInstitution
            }
        });
    },

    editInstitution: function(grid, record) {
        var edit = Ext.create('CPRS.view.acadinstitution.Edit').show();
        
        if(record){
        	edit.down('form').loadRecord(record);
        }
    },
    
    updateInstitution: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
        
        
		if (values.id > 0){
			record.set(values);
		} else{
			record = Ext.create('CPRS.model.AcadInstitution');
			record.set(values);
			record.setId(0);
			this.getAcadInstitutionsStore().add(record);
		}
        
		win.close();
        this.getAcadInstitutionsStore().sync();
    },
    
    deleteInstitution: function(button) {
    	
    	var grid = this.getAcadInstitutionlist(),
    	record = grid.getSelectionModel().getSelection(), 
        store = this.getAcadInstitutionsStore();

	    store.remove(record);
	    this.getAcadInstitutionsStore().sync();
    }
});
