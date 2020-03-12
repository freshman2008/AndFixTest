var express = require('express');
var router = express.Router();

var dataSuccess = {
    code: 100, 
    message: '成功',
    data: {
        downloadUrl: 'http://192.168.8.49:3000/images/hs.apatch',
        versionName: '1.0.2',
        patchMessage: 'hello'
    }
};

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.get('/getPatchInfo', function(req, res, next) {
  res.end(JSON.stringify(dataSuccess));
});

module.exports = router;
