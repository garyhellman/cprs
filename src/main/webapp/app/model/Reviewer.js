Ext.define('CPRS.model.Reviewer' ,{
    extend: 'Ext.data.Model',
    requires: ['CPRS.model.AffSchool', 
               'Ext.data.HasManyAssociation', 
               'Ext.data.BelongsToAssociation'],

    fields: [
             'id',
             'reviewer', 
             'phone', 
             'email'
             ],

    hasMany: [{
            	 model: 'AffSchool',
            	 name: 'affschools',
            	 associationKey: 'affschools'
             }],
    proxy: {
     	type: 'ajax',
     	api: {
         	read: 'data/reviewers.json',
         	update: 'data/updatereviewers.json'
     	},
     	reader: {
     		type: 'json',
     		root: 'reviewers',
     		successProperty: 'success'
     	}
    }
             

});

