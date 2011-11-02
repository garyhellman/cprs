Ext.define('CPRS.view.reviewer.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.revieweredit',

    title : 'Edit Reviewer',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'textfield',
                        name : 'reviewer',
                        fieldLabel: 'Reviewer'
                    },
                    {
                        xtype: 'textfield',
                        name : 'phone',
                        fieldLabel: 'Phone'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: 'Email'
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
