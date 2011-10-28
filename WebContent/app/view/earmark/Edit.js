Ext.define('EarmarkApp.view.earmark.Edit', {
    
    extend: 'Ext.window.Window',
    alias: 'widget.earmarkedit',
    requires: [
	  'Ext.form.Panel',
 	  'Ext.form.field.ComboBox',
      'Ext.form.FieldContainer',
      'Ext.layout.container.Column',
      'Ext.form.field.Hidden'
	],
    title: 'Edit Earmark',
	layout: 'fit',
	autoShow: true,
	width: 640,
	height: 400,
   
    EarmarkStoreId: 'Earmark',
    SpendingCommitteeStoreId: 'SpendingCommittees',
	SponsorStoreId: 'Sponsors',
	modelName: 'Earmark',
	currentRecord: 0,
	EarmarkStoreProxy: null,
    
	
    initComponent: function(){

	 this.items = [
	  {
	  	xtype: 'form',
	  	bodyPadding: 5,
	  	fieldDefaults: {
	  		labelAlign: 'left',
	  		labelWidth: 80,
	  		msgTarget: 'side'
	  	},
	  	defaultType: 'textfield',
	  	layout: 'anchor',
	  	
	  	items: [{
	  		xtype: 'combo',
	  		fieldLabel: 'Sponsor',
	  		name: 'IDSPONSOR',
	  		store: Ext.getStore(this.SponsorStoreId),
	  		displayField: 'FULLNAME',
	  		valueField: 'IDSPONSOR',
	  		anchor: '100%',
	  		allowBlank: false
	  	}, {
	  		xtype: 'combo',
	  		fieldLabel: 'Committee',
	  		name: 'IDSPENDINGCOMMITTEE',
	  		store: Ext.getStore(this.SpendingCommitteeStoreId),
	  		displayField: 'COMMITTEENAME',
	  		valueField: 'IDSPENDINGCOMMITTEE',
	  		anchor: '100%',
	  		allowBlank: false
	  	}, {
	  		fieldLabel: 'Agency',
	  		name: 'AGENCY_TITLE',
	  		anchor: '100%'
	  	}, {
	  		fieldLabel: 'Bureau',
	  		name: 'BUREAU_TITLE',
	  		anchor: '100%'
	  	}, {
	  		xtype: 'fieldcontainer',
	  		fieldLabel: 'Funding',
	  		layout: 'column',
	  		items: [{
	  			xtype: 'container',
	  			columnWidth: 0.5,
	  			layout: 'anchor',
	  			items: [{
	  				xtype: 'numberfield',
	  				hideTrigger: true,
	  				fieldLabel: 'House Cmtee',
	  				name: 'AMT_HC'
	  			}, {
	  				xtype: 'numberfield',
	  				hideTrigger: true,
	  				fieldLabel: 'Senate Cmtee',
	  				name: 'AMT_SC'
	  			}, {
	  				xtype: 'numberfield',
	  				fieldLabel: 'Year Enacted',
	  				name: 'ENACTED_YEAR',
	  				anchor: '95%'
	  			}]
	  		}, { // 2nd column
						xtype: 'container',
						columnWidth: 0.5,
						layout: 'anchor',
						items: [{
							xtype: 'numberfield',
							hideTrigger: true,
							fieldLabel: 'House Floor',
							name: 'AMT_HF'
						}, {
							xtype: 'numberfield',
							hideTrigger: true,
							fieldLabel: 'Senate Floor',
							name: 'AMT_SF'
						}, {
							xtype: 'numberfield',
							hideTrigger: true,
							fieldLabel: 'Conf Cmtee',
							name: 'AMT_CONF'
						}]
					}] // 2nd column 
				}, {
					xtype: 'textarea',
					labelAlign: 'top',
					name: 'EARMARK_DESCRIPTION',
					fieldLabel: 'Description',
					emptyText: 'Description',
					anchor: '100% -185', // set height to be 100% - 30px
					allowBlank: false,
					msgTarget: 'under'
				}, {
					xtype: 'hiddenfield',
					name: 'EARMARK_ID',
					value: -1
				}]
			
		}];
		
	   this.buttons =  [{
		 text: 'Save',
		 formBind: true,
		 action: 'save'
	   }];
	   
       this.callParent(arguments);
    } // initComponent
});