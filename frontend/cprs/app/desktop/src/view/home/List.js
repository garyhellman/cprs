Ext.define('CPRS.view.home.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.homelist',

    title : 'Home',
	closable: true,

    initComponent: function() {
		
        console.log('Initializing Homes List View!');
		
		
        this.store = {
            fields: ['field1', 'field2'],
            data  : [
                {field1: 'Ed',    field2: 'ed@sencha.com'},
                {field1: 'Tommy', field2: 'tommy@sencha.com'}
            ]
        };

        this.columns = [
            {header: 'Field1',  dataIndex: 'field1',  flex: 1},
            {header: 'Field2', dataIndex: 'field2', flex: 1}
        ];

        this.callParent(arguments);
    }
});
