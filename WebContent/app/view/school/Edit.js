Ext.define('CPRS.view.school.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.schooledit',

    title : 'Edit School',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name : 'schoolname',
                        fieldLabel: 'School Name'
                    },
                    {
                        xtype: 'textfield',
                        name : 'pryear',
                        fieldLabel: 'PR Year'
                    },
                    {
                        xtype: 'textfield',
                        name : 'meetingname',
                        fieldLabel: 'Meeting'
                    },
                    {
                        xtype: 'textfield',
                        name : 'reviewers',
                        fieldLabel: 'Reviewers'
                    }
                    
                    
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});
