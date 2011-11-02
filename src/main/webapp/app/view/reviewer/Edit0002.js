Ext.require([
    'Ext.form.*',
    'Ext.layout.container.Column',
    'Ext.tab.Panel'
]);

Ext.define('CPRS.view.reviewer.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.revieweredit',

    title : 'Edit Reviewer',
    layout: 'fit',
    autoShow: true,
	resizable: true,
	width: 400,
	modal: true,

	iconCls: 'icon-user-edit',

    initComponent: function() {
        console.log('Initialized Edit Reviewer Component!');
        
		var me = this;

		
		me.items = [ {
			// xtype: 'form',
			// padding: 5,
			// bodyPadding: 10,
			// bodyBorder: true,
// 
			// defaultType: 'textfield',
			// defaults: {
				// anchor: '100%'
			// },
                xtype:'tabpanel',
                plain:true,
                activeTab: 0,
                height:235,
                defaults:{bodyStyle:'padding:10px'},
                items:[{
					xtype: 'form',
					padding: 5,
					bodyPadding: 10,
					bodyBorder: true,
                    title:'Contact Details',
//                    defaults: {width: 230},
//                    defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'First Name',
                        name: 'first',
                        allowBlank:false,
                        value: 'Jamie'
                    },{
                        fieldLabel: 'Last Name',
                        name: 'last',
                        value: 'Avins'
                    },{
                        fieldLabel: 'Company',
                        name: 'company',
                        value: 'Ext JS'
                    }, {
                        fieldLabel: 'Email',
                        name: 'email',
                        vtype:'email'
                    }]
                },{
                    title:'Disciplinary Expertise',
                    defaults: {width: 230},
 //                  defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'Home',
                        name: 'home',
                        value: '(888) 555-1212'
                    },{
                        fieldLabel: 'Business',
                        name: 'business'
                    },{
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    },{
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                },{
                    title:'Affiliated Schools',
                    defaults: {width: 230},
 //                   defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'Home',
                        name: 'home',
                        value: '(888) 555-1212'
                    },{
                        fieldLabel: 'Business',
                        name: 'business'
                    },{
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    },{
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                },{
                    title:'Review Partners',
                    defaults: {width: 230},
//                    defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'Home',
                        name: 'home',
                        value: '(888) 555-1212'
                    },{
                        fieldLabel: 'Business',
                        name: 'business'
                    },{
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    },{
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                },{
                    cls: 'x-plain',
                    title: 'Biography',
                    layout: 'fit',
                    items: {
                        xtype: 'htmleditor',
                        name: 'bio2',
                        fieldLabel: 'Biography'
                    }
                }]
            }];
		
		
/*					
			api: {
			    submit: userService.userFormPost
			},
			
			fieldDefaults: {
				msgTarget: 'side'
			},

			items: [ {
				name: 'userName',
				fieldLabel: i18n.user_username,
				allowBlank: false
			}, {
				name: 'firstName',
				fieldLabel: i18n.user_firstname,
				allowBlank: false
			}, {
				name: 'name',
				fieldLabel: i18n.user_lastname,
				allowBlank: false
			}, {
				name: 'email',
				fieldLabel: i18n.user_email,
				vtype: 'email',
				allowBlank: false
			}, {
				name: 'passwordHash',
				fieldLabel: i18n.user_password,				
				inputType: 'password',
				id: 'pass'
			}, {
				name: 'password-confirm',
				fieldLabel: i18n.user_confirmpassword,				
				vtype: 'password',
				inputType: 'password',
				initialPassField: 'pass'
			}, {
                xtype: 'combobox',
                fieldLabel: i18n.user_language,
                name: 'locale',
                store: Ext.create('Ext.data.ArrayStore', {
                    fields: ['code', 'language'],
                    data : [['de', i18n.user_language_german], 
                            ['en', i18n.user_language_english]]
                }),
                valueField: 'code',
                displayField: 'language',
                queryMode: 'local',
                emptyText: i18n.user_selectlanguage,
                allowBlank: false,
                forceSelection: true
            }, {
				fieldLabel: i18n.user_enabled,
				name: 'enabled',
				xtype: 'checkboxfield',
				inputValue: 'true',
				uncheckedValue: 'false'
			},{
				xtype: 'itemselector',
	            name: 'roleIds',
	            fieldLabel: i18n.user_roles,
	            store: 'Roles',
	            displayField: 'name',
	            valueField: 'id',
	            allowBlank: true
	        } ],

			buttons: [ {
				xtype: 'button',
				text: i18n.save,
				action : 'save',
				iconCls: 'icon-save'
			}, {
				text: i18n.cancel,
				scope: me,
				handler: me.close,
				iconCls: 'icon-cancel'
			} ]
		} ];
*/
        
        

/*    	
        Ext.app.REMOTING_API.enableBuffer = 100;
        Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);
        
        // provide feedback for any errors
        Ext.tip.QuickTipManager.init();
        
        var basicInfo = Ext.create('Ext.form.Panel', {
            // configs for FormPanel
            title: 'Basic Information',
            border: false,
            bodyPadding: 10,
            // configs for BasicForm
            api: {
                // The server-side method to call for load() requests
                load: reviewerService.getBasicInfo,
                // The server-side must mark the submit handler as a 'formHandler'
                submit: reviewerService.updateBasicInfo
            },
            // specify the order for the passed params
            paramOrder: ['uid', 'foo'],
            dockedItems: [{
                dock: 'bottom',
                xtype: 'toolbar',
                ui: 'footer',
                style: 'margin: 0 5px 5px 0;',
                items: ['->', {
                    text: 'Submit',
                    handler: function(){
                        basicInfo.getForm().submit({
                            params: {
                                foo: 'bar',
                                uid: 34
                            }
                        });
                    }      
                }]
            }],
            defaultType: 'textfield',
            defaults: {
                anchor: '100%'
            },
            items: [{
                fieldLabel: 'Name',
                name: 'name'
            },{
                fieldLabel: 'Email',
                msgTarget: 'side',
                name: 'email'
            },{
                fieldLabel: 'Company',
                name: 'company'
            }]
        });
        
        var phoneInfo = Ext.create('Ext.form.Panel', {
            title: 'Phone Numbers',
            border: false,
            api: {
                load: reviewerService.getPhoneInfo
            },
            bodyPadding: 10,
            paramOrder: ['uid'],
            defaultType: 'textfield',
            defaults: {
                anchor: '100%'
            },
            items: [{
                fieldLabel: 'Office',
                name: 'office'
            },{
                fieldLabel: 'Cell',
                name: 'cell'
            },{
                fieldLabel: 'Home',
                name: 'home'
            }]
        });
        
        var locationInfo = Ext.create('Ext.form.Panel', {
            title: 'Location Information',
            border: false,
            bodyPadding: 10,
            api: {
                load: reviewerService.getLocationInfo
            },
            paramOrder: ['uid'],
            defaultType: 'textfield',
            defaults: {
                anchor: '100%'
            },
            items: [{
                fieldLabel: 'Street',
                name: 'street'
            },{
                fieldLabel: 'City',
                name: 'city'
            },{
                fieldLabel: 'State',
                name: 'state'
            },{
                fieldLabel: 'Zip',
                name: 'zip'
            }]
        });
        
        var accordion = Ext.create('Ext.panel.Panel', {
            layout: 'accordion',
            renderTo: Ext.getBody(),
            title: 'My Profile',
            width: 300,
            height: 240,
            items: [basicInfo, phoneInfo, locationInfo]
        });
        
        // load the forms (notice the load requests will get batched together)
        basicInfo.getForm().load({
            // pass 2 arguments to server side getBasicInfo method (len=2)
            params: {
                foo: 'bar',
                uid: 34
            }
        });

        phoneInfo.getForm().load({
            params: {
                uid: 5
            }
        });

        // defer this request just to simulate the request not getting batched
        // since it exceeds to configured buffer
//        Ext.Function.defer(function(){
//            locationInfo.getForm().load({
//                params: {
//                    uid: 5
//                }
//            });
//        }, 200);

        // rpc call
        //TestAction.doEcho('sample');
*/    	

    	
    	
    	
        var bd = Ext.getBody();
    	
    	
//        bd.createChild({tag: 'h2', html: 'Form 5 - ... and forms can contain TabPanel(s)'});

        var tab2 = Ext.create('Ext.form.Panel', {
            title: 'Inner Tabs',
            bodyStyle:'padding:5px',
            width: 600,
            fieldDefaults: {
                labelAlign: 'top',
                msgTarget: 'side'
            },
            defaults: {
                anchor: '100%'
            },

            items: [{
                layout:'column',
                border:false,
                items:[{
                    columnWidth:.5,
                    border:false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    items: [{
                        fieldLabel: 'First Name',
                        name: 'first',
                        anchor:'95%'
                    }, {
                        fieldLabel: 'Company',
                        name: 'company',
                        anchor:'95%'
                    }]
                },{
                    columnWidth:.5,
                    border:false,
                    layout: 'anchor',
                    defaultType: 'textfield',
                    items: [{
                        fieldLabel: 'Last Name',
                        name: 'last',
                        anchor:'95%'
                    },{
                        fieldLabel: 'Email',
                        name: 'email',
                        vtype:'email',
                        anchor:'95%'
                    }]
                }]
            },{
                xtype:'tabpanel',
                plain:true,
                activeTab: 0,
                height:235,
                defaults:{bodyStyle:'padding:10px'},
                items:[{
                    title:'Personal Details',
                    defaults: {width: 230},
                    defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'First Name',
                        name: 'first',
                        allowBlank:false,
                        value: 'Jamie'
                    },{
                        fieldLabel: 'Last Name',
                        name: 'last',
                        value: 'Avins'
                    },{
                        fieldLabel: 'Company',
                        name: 'company',
                        value: 'Ext JS'
                    }, {
                        fieldLabel: 'Email',
                        name: 'email',
                        vtype:'email'
                    }]
                },{
                    title:'Phone Numbers',
                    defaults: {width: 230},
                    defaultType: 'textfield',

                    items: [{
                        fieldLabel: 'Home',
                        name: 'home',
                        value: '(888) 555-1212'
                    },{
                        fieldLabel: 'Business',
                        name: 'business'
                    },{
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    },{
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                },{
                    cls: 'x-plain',
                    title: 'Biography',
                    layout: 'fit',
                    items: {
                        xtype: 'htmleditor',
                        name: 'bio2',
                        fieldLabel: 'Biography'
                    }
                }]
            }],

            buttons: [{
                text: 'Save'
            },{
                text: 'Cancel'
            }]
        });

        console.log('about to render tab2');
        tab2.render(document.body);
    	
        console.log('done with about to render tab2');
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

        
        me.callParent(arguments);
    }
});
