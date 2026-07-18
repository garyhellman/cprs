Ext.define('CPRS.controller.Doccats', {
	extend: 'Ext.app.Controller',
	
	views: [
	        'doccat.List'
	        ],


//	views: [ 'doccat.List', 'doccat.Edit' ],
//	stores: [ 'Doccats', 'Roles' ],
//	models: [ 'Doccat', 'Role' ],
//	refs: [ {
//		ref: 'doccatList',
//		selector: 'doccatlist'
//	}, {
//		ref: 'doccatEditForm',
//		selector: 'doccatedit form'
//	}, {
//		ref: 'doccatEditWindow',
//		selector: 'doccatedit'
//	} ],

	init: function() {
		console.log('Initialized Doccats! This happens before the Application launch function is called.');
//		this.control({
//			'doccatlist': {
//				itemdblclick: this.editDoccatFromDblClick,
//				itemclick: this.enableActions,
//				beforerender: this.onBeforeRender
//			},
//			'doccatedit button[action=save]': {
//				click: this.updateDoccat
//			},
//			'doccatlist button[action=add]': {
//				click: this.createDoccat
//			},
//			'doccatlist button[action=edit]': {
//				click: this.editDoccatFromButton
//			},
//			'doccatlist button[action=delete]': {
//				click: this.deleteDoccat
//			},
//			'doccatlist textfield': {
//				filter: this.handleFilter
//			}
//		});
		
	}
//,

//	handleFilter: function(field, newValue) {
//		var myStore = this.getDoccatsStore();
//		if (newValue) {
//			myStore.remoteFilter = false;
//			myStore.clearFilter(true);
//			myStore.remoteFilter = true;
//			myStore.filter('filter', newValue);
//			
//			this.getDoccatList().down('button[action=export]').setParams({
//				filter: newValue
//			});			
//		} else {
//			myStore.clearFilter();
//			this.getDoccatList().down('button[action=export]').setParams();				
//		}
//	},
//
//	editDoccatFromDblClick: function(grid, record) {
//		this.editDoccat(record);
//	},
//
//	editDoccatFromButton: function() {
//		this.editDoccat(this.getDoccatList().getSelectionModel().getSelection()[0]);
//	},
//
//	editDoccat: function(record) {
//		Ext.widget('doccatedit');
//
//		var form = this.getDoccatEditForm().getForm();
//		form.loadRecord(record);
//		form.setValues({
//			'roleIds': Ext.Array.map(record.raw.roles, function(item) {
//				return item.id;
//			})
//		});
//	},
//
//	createDoccat: function() {
//		Ext.widget('doccatedit');
//		this.getDoccatEditForm().getForm().isValid();
//	},
//
//	deleteDoccat: function(button) {
//		var record = this.getDoccatList().getSelectionModel().getSelection()[0];
//		if (record) {
//			Ext.Msg.confirm(i18n.doccat_delete+'?', i18n.delete_confirm + ' ' + record.data.name,
//					this.afterConfirmDeleteDoccat, this);
//		}
//	},
//
//	afterConfirmDeleteDoccat: function(btn) {
//		if (btn === 'yes') {
//			var record = this.getDoccatList().getSelectionModel().getSelection()[0];
//			if (record) {
//				this.getDoccatsStore().remove(record);
//				this.getDoccatsStore().sync();
//				this.doGridRefresh();
//				CPRS.component.Notification.info(i18n.successful, i18n.doccat_deleted);
//			}
//		}
//	},
//
//	enableActions: function(button, record) {
//		this.toggleEditButtons(true);
//	},
//
//	toggleButton: function(enable, buttonId) {
//		var button = this.getDoccatList().down(buttonId);
//		if (enable) {
//			button.enable();
//		} else {
//			button.disable();
//		}
//	},
//
//	toggleEditButtons: function(enable) {
//		this.toggleButton(enable, 'button[action=delete]');
//		this.toggleButton(enable, 'button[action=edit]');
//	},
//
//
//	updateDoccat: function(button) {
//		var form = this.getDoccatEditForm(), record = form.getRecord();
//
//		form.getForm().submit({
//			params: {
//				id: record ? record.data.id : ''
//			},
//			scope: this,
//			success: function(form, action) {
//				this.doGridRefresh();
//				this.getDoccatEditWindow().close();
//				CPRS.component.Notification.info(i18n.successful, i18n.doccat_saved);
//			}
//		});
//	},
//
//	onBeforeRender: function() {
//		var myStore = this.getDoccatsStore();
//		myStore.remoteFilter = false;
//		myStore.clearFilter();
//		myStore.remoteFilter = true;
//			this.doGridRefresh();
//	},
//
//	doGridRefresh: function() {
//		this.getDoccatList().down('pagingtoolbar').doRefresh();
//		this.toggleEditButtons(false);
//
//	}

});