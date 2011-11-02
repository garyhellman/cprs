Ext.define('CPRS.controller.Reviewers', {
    extend: 'Ext.app.Controller',
    //    stores: ['Reviewers'],
    //    models: ['Reviewer'],
    
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
        console.log('Double clicked on ' + record.get('reviewer'));
                var view = Ext.widget('revieweredit');
    
        		view.down('form').loadRecord(record);
                var form = this.getReviewerEditForm().getForm();
                form.loadRecord(record);
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
