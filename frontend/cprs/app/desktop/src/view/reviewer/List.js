Ext.define('CPRS.view.reviewer.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.reviewerlist',

    title : 'Reviewers',
	closable: true,

    initComponent: function() {
		
        console.log('Initializing reviewer List View!');
		
		
        this.store = {
		    fields: [
			'reviewer', 
			'phone', 
			'email'
			],
            data  : [
            {id:1, reviewer: 'Ruma Banerjee',    
            	phone: '1112223456',
            	email: 'RBanerjee@abc.com'
            },
            {id:2, reviewer: 'Robert A Copeland',    
            	phone: '1112223456',
            	email: 'Copeland@abc.com'
            },
            {id:3, reviewer: 'Ron W Darbeau',    
            	phone: '1112223456',
            	email: 'Darbeau@abc.com'
            },
            {id:4, reviewer: 'Ron C Estler',    
            	phone: '1112223456',
            	email: 'Estler@abc.com'
            },
            {id:5, reviewer: 'Joseph S Francisco',    
            	phone: '1112223456',
            	email: 'Francisco@abc.com'
            },
            {id:6, reviewer: 'Cornelia D Gilyard',    
            	phone: '1112223456',
            	email: 'Gilyard@abc.com'
            }
            ]
        };

        this.columns = [
            {header: 'Reviewer',  dataIndex: 'reviewer',  flex: 1},
            {header: 'Phone', dataIndex: 'phone', flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1},
            {
            	header: ' ',
            	type: 'action'
            }
        ];

        this.callParent(arguments);
    }
});
