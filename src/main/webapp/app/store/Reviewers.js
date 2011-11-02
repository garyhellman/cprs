Ext.define('CPRS.store.Reviewers' ,{
    extend: 'Ext.data.Store',
    model: 'CPRS.model.Reviewer',
    autoLoad: true,
/*    
    proxy: {
    	type: 'ajax',
    	api: {
        	read: 'data/reviewers.json',
        	update: 'data/updatereviewers.json'
    	},
    	reader: {
    		type: 'json',
    		root: 'reviewers',
    		successProperty: 'success'
    	}
    }
*/
	data: [
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
});
