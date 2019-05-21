<head>
  <title>Statistics</title>
  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
  <link href="assets/styles.css" rel="stylesheet" media="screen">
  <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
           <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
       <![endif]-->
  <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<!-- morris graph chart -->
<div class="row-fluid section">
  <!-- block -->
  <div class="block">
    <div class="navbar navbar-inner block-header">
      <div class="muted pull-left">Morris.js <small>Monthly growth</small></div>
      <div class="pull-right"><span class="badge badge-warning">View More</span>

      </div>
    </div>
    <div class="block-content collapse in">
      <div class="span12">
        <div id="hero-graph" style="height: 230px;"></div>
      </div>
    </div>
  </div>
  <!-- /block -->
</div>


Morris.Area({
element: 'hero-area',
data: [
{period: '2010 Q1', iphone: 2666, ipad: null, itouch: 2647},
{period: '2010 Q2', iphone: 2778, ipad: 2294, itouch: 2441},
{period: '2010 Q3', iphone: 4912, ipad: 1969, itouch: 2501},
{period: '2010 Q4', iphone: 3767, ipad: 3597, itouch: 5689},
{period: '2011 Q1', iphone: 6810, ipad: 1914, itouch: 2293},
{period: '2011 Q2', iphone: 5670, ipad: 4293, itouch: 1881},
{period: '2011 Q3', iphone: 4820, ipad: 3795, itouch: 1588},
{period: '2011 Q4', iphone: 15073, ipad: 5967, itouch: 5175},
{period: '2012 Q1', iphone: 10687, ipad: 4460, itouch: 2028},
{period: '2012 Q2', iphone: 8432, ipad: 5713, itouch: 1791}
],
xkey: 'period',
ykeys: ['iphone', 'ipad', 'itouch'],
labels: ['iPhone', 'iPad', 'iPod Touch'],
lineWidth: 2,
hideHover: 'auto',
lineColors: ["#81d5d9", "#a6e182", "#67bdf8"]
});
