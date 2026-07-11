Ext.require(['Ext.form.*', 'Ext.layout.container.Column', 'Ext.tab.Panel']);
var affSchArray = new Array();

Ext.define('CPRS.view.reviewer.Edit', {
    extend: 'Ext.window.Window',
    alias: 'widget.revieweredit',
    
    title: 'Edit Reviewer',
    layout: 'fit',
    autoShow: true,
    resizable: true,
    width: 800,
	height: 600,
    modal: true,

	requires: ['Ext.ux.form.ItemSelector'],
	
    iconCls: 'icon-user-edit',
    
    initComponent: function(){
        console.log('Initialized Edit Reviewer Component!');
        
        var me = this;
        affSchArray = ['1', '2', '5'];
        
	    var ds = Ext.create('Ext.data.ArrayStore', {
	        data: [[123,'One Hundred Twenty Three'],
	            ['1', 'One'], ['2', 'Two'], ['3', 'Three'], ['4', 'Four'], ['5', 'Five'],
	            ['6', 'Six'], ['7', 'Seven'], ['8', 'Eight'], ['9', 'Nine']],
	        fields: ['value','text'],
	        sortInfo: {
	            field: 'value',
	            direction: 'ASC'
	        }
	    });
	
        
        
        me.items = [{
            xtype: 'form',
            items: [{
                xtype: 'tabpanel',
                plain: true,
                activeTab: 0,
                height: 525,
                defaults: {
                    bodyStyle: 'padding:10px'
                },
                
                items: [{
                    title: 'Contact Details',
                    defaultType: 'textfield',
                    items: [{
						xtype: 'container',
						anchor: '100%',
						layout: 'column',
						items: [{
							xtype: 'container',
							columnWidth: 0.5,
							layout: 'anchor',
		                    defaultType: 'textfield',
		                    items: [{
								xtype: 'combo',
		                        fieldLabel: 'Title',
		                        name: 'title',
								store: [
								[1, 'Mr.'],
								[2, 'Mrs.'],
								[3, 'Dr.']
								],
		                        forceSelection: true,
		                        allowBlank: false,
		                        //width: '74px',
		                        anchor: '40%'
		                    }, {
		                        fieldLabel: 'First Name',
		                        name: 'reviewer',
		                        allowBlank: false,
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Email',
		                        name: 'email',
		                        vtype: 'email',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Username',
		                        name: 'username',
		                        value: ' ',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: ' ',
		                        name: ' ',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Organization',
		                        name: 'organization',
		                        value: '',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Address',
		                        name: 'address1',
		                        value: '',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: '',
		                        name: 'address2',
		                        value: '',
		                        anchor: '96%'
		                    }, {
								xtype: 'combo',
		                        fieldLabel: 'State',
		                        name: 'state',
								store: [
								[1, 'MD'],
								[2, 'DC'],
								[3, 'VA']
								],
		                        forceSelection: true,
		                        allowBlank: false,
		                        anchor: '80%'
		                    }, {
		                        fieldLabel: 'Post Code',
		                        name: 'postcode',
		                        value: '',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Phone No',
		                        name: 'phone',
		                        value: '',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Since',
		                        name: 'joinyear',
		                        value: '2003',
		                        anchor: '96%'
		                    }]
						},
						{
							xtype: 'container',
							columnWidth: 0.5,
							layout: 'anchor',
		                    defaultType: 'textfield',
		                    items: [{
		                        fieldLabel: '.',
		                        name: 'x',
		                        value: '.',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Last Name',
		                        name: 'last',
		                        value: 'Spencer',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: '',
		                        name: '',
								hidden: true,
								labelSeparator: '&nbsp;',
		                        anchor: '96%'
							}, {
		                        fieldLabel: 'Company',
		                        name: 'company',
		                        value: 'Ext JS',
		                        anchor: '96%'
		                    }, {
		                        fieldLabel: 'Email',
		                        name: 'email',
		                        vtype: 'email',
		                        anchor: '96%'
		                    }]
						}]
					}]
					
					
					
					
					
					
					
					
					
					
					
					
					
                }, {
                    title: 'Disciplenary Expertise',
                    defaultType: 'textfield',
                    
                    items: [{
                        fieldLabel: 'Home',
                        name: 'phone',
                        value: '(888) 555-1212'
                    }, {
                        fieldLabel: 'Business',
                        name: 'business'
                    }, {
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    }, {
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                }, {
                    title: 'Affiliated Schools',
//                    defaultType: 'textfield',
            //name: 'affschools',
            		items : [ {
						xtype: 'form',
						padding: 5,
						bodyPadding: 10,
						bodyBorder: true,
						
						defaultType: 'textfield',
						defaults: {
							anchor: '100%'
						},
						fieldDefaults: {
							msgTarget: 'side'
						},
						
						items: [{
							/*						
		 xtype: 'itemselector',
		 name: 'roleIds',
		 fieldLabel: "Affiliated Schools",
		 store: ds,
		 displayField: 'text',
		 valueField: 'value',
		 value: ['3', '4', '6'],
		 
		 allowBlank: false,
		 // minSelections: 2,
		 // maxSelections: 3,
		 msgTarget: 'side'
		 */
							xtype: 'itemselector',
							//name: 'itemselector',
							
							//renderTo: 'affschools',
							
							//anchor: '100%',
							fieldLabel: 'ItemSelector',
							imagePath: '../ux/images/',
							
							store: ds,
							displayField: 'text',
							valueField: 'value',
							value: affSchArray,
							//value: ['1', '2', '3'],
							
							allowBlank: false,
							// minSelections: 2,
							// maxSelections: 3,
							msgTarget: 'side'
						
						}]
					}]
                }, {
                    title: 'Review Partners',
                    defaultType: 'textfield',
                    
                    items: [{
                        fieldLabel: 'Home',
                        name: 'phone',
                        value: '(888) 555-1212'
                    }, {
                        fieldLabel: 'Business',
                        name: 'business'
                    }, {
                        fieldLabel: 'Mobile',
                        name: 'mobile'
                    }, {
                        fieldLabel: 'Fax',
                        name: 'fax'
                    }]
                }]
            
            }],
            buttons: [{
                text: 'Save',
                action: 'save'
            }, {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];
        
        
        
        
        me.callParent(arguments);
    },
    
    /**
     * Used to bind a store to this dataview.
     * Delegates to bindStore and also shows this view
     * @param {Ext.data.Model} record The record to bind
     * @param {Ext.data.Store} store The reviews store used by the application
     */
    bind: function(record, store) {
    	console.log('in reviewer edit bind function: ' + record.data.id + ' ' + record.data.reviewer + ' ' + record.data.email );
        //put the affschools into the store and bind the store to this dataview(?)
        // store.loadData(record.data.affschools || []);
        //affSchArray = record.data.affschools;
    	console.log('in reviewer edit bind function: store.count():: ' + store.count() );
    	console.log('in reviewer edit bind function: affSchArray[0]:: ' + affSchArray[0]);
    	console.log('bind: ' + affschoolsStore);
//    	store.load();
//    	console.log('in reviewer edit bind function: store.count():: ' + store.count() );
        //this.dataview.bindStore(store);
    	//affSchArray
    	//var afschs = record.affschools().getAt(0).get("value");
    	
/*
    	//var user = record.data;
        var revee = Ext.ModelManager.getModel('CPRS.model.Reviewer');
        console.log("Affiliated Schools for " + revee);
        
        
        this.revee = record;
        console.log("Affiliated Schools for " + revee);

        console.log("Affiliated Schools for " + revee.get('reviewer') + ":");

        //iterate over the Orders for each User
        revee.affschools().each(function(affschool) {
            console.log("Value: " + affschool.getValue() + ", which contains items:");

        })
*/    	
    }
    
});
