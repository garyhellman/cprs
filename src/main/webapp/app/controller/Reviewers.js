Ext.define('CPRS.controller.Reviewers', {
    extend: 'Ext.app.Controller',
    stores: ['Reviewers', 'AffSchools'],
    models: ['Reviewer'],
    
    views: ['reviewer.List', 'reviewer.Edit'],
    refs: [{
        ref: 'reviewerList',
        selector: 'reviewerlist'
    }, {
        ref: 'reviewerEditForm',
        selector: 'revieweredit form'
    }, {
        ref: 'reviewerEditWindow',
        selector: 'revieweredit'
    }],
    
    
    
    init: function(){
        console.log('Initialized Reviewers! This happens before the Application launch function is called');
        this.control({
            'reviewerlist': {
                itemdblclick: this.editReviewer
            },
            'revieweredit button[action=save]': {
                click: this.updateReviewer
            }
        });
    },
    
    onPanelRendered: function(){
        console.log('The panel was rendered');
    },
    
    editReviewer: function(grid, record){
		var me = this;
        console.log('Double clicked on ' + record.get('reviewer'));
        
        //console.log('Count in affschStore ' + record.getAffSchoolsStore().count() );
        
        var view = Ext.widget('revieweredit');
    
        view.down('form').loadRecord(record);

        var MyReviewer = Ext.ModelManager.getModel('CPRS.model.Reviewer'); 
        MyReviewer.load(record.data.id, {
        	success: function(reviewer) {
        		console.log("Reviewer: " + reviewer.get('reviewer'));
        	}
        });

        // me.getReviewerEditForm().bind(record);
        //me.getAffSchoolsStore().load();
        view.bind(record, me.getAffSchoolsStore());
        		
                //var form = this.getReviewerEditForm().getForm();
                //form.loadRecord(record);
                
        //        form.setValues({
        //            'roleIds': Ext.Array.map(record.raw.roles, function(item){
        //                return item.id;
        //            })
        //        });
    
    },
    updateReviewer: function(button){
        console.log('Reviewers:updateReviewer:: clicked the save button ');
              var win = button.up('window'), form = win.down('form'), record = form.getRecord(), values = form.getValues();
    
        console.log('Reviewers:updateReviewer:: ' + values);
              record.set(values);
              win.close();
    
              this.getReviewersStore().sync();
    }
    
    
});
