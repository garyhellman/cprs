Ext.define('CPRS.view.acadinstitution.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.acadinstitutionlist',
    
    //requires: ['Ext.toolbar.Paging'],
    
    iconCls: 'icon-grid',

    title : 'Academic Institutions',
    store: 'AcadInstitutions',

    columns: [{
    	header: "Id",
		width: 16,
		flex:1,
		dataIndex: 'id'
	},{
		header: "Name",
		width: 160,
		flex:1,
		dataIndex: 'name'
	},{
		header: "Department Id",
		width: 12,
		flex:1,
		dataIndex: 'deptId'
	},{
		header: "Next Review Year",
		width: 9,
		flex:1,
		dataIndex: 'nextReviewYear'
	},{
		header: "deleteFlag",
		width: 2,
		flex:1,
		dataIndex: 'deleteFlag'
	}],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
                iconCls: 'icon-save',
                itemId: 'add',
                text: 'Add',
                action: 'add'
            },{
                iconCls: 'icon-delete',
                text: 'Delete',
                action: 'delete'
            }]
        },
        {
            xtype: 'pagingtoolbar',
            dock:'top',
            store: 'AcadInstitutions',
            displayInfo: true,
            displayMsg: 'Displaying acadinstitutions {0} - {1} of {2}',
            emptyMsg: "No acadinstitutions to display"
        }];
		
		this.callParent(arguments);
	}
});
