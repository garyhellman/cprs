Ext.define('CPRS.model.Reviewer', {
    extend: 'Ext.data.Model',
    requires: ['CPRS.model.AffSchool'],

    fields: [
        'id',
        'reviewer',
        'phone',
        'email'
    ],

    hasMany: {
        model: 'AffSchool',
        name: 'affschools',
        associationKey: 'affschools'
    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'data/reviewers.json',
            update: 'data/updateReviewers.json'
        },
        reader: {
            type: 'json',
            rootProperty: 'reviewers',
            successProperty: 'success'
        }
    }
});
