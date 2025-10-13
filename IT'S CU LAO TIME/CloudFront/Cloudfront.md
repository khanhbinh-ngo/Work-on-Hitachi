learning Cloudfront: 17092025

## I. Basic knowledge and how to use Cloudfront with S3
1. what is cloudfront
- Cloudfront is a web service that speeds up distribution of your static and dynamic web content, such as .html, .css, .js, and image files, to your users. CloudFront delivers your content through a worldwide network of data centers called edge locations. When a user requests content that you're serving with CloudFront, the user is routed to the edge location that provides the lowest latency (time delay), so that content is delivered with the best possible performance.
- CloudFront is optimized to work with other Amazon Web Services, like Amazon S3, Amazon EC2, Elastic Load Balancing, and Amazon Route 53. It is also integrated with AWS - Shield for DDoS mitigation, and works seamlessly with AWS WAF for application layer security. CloudFront is designed to be used with any web server, including web servers that are not hosted on AWS.  

2. how to use cloudfront
    There are 4 steps to use cloudfront
    a. Step 1: Create origin ( S3 bucket, web server, media store)
    b. Step 2: Create distribution (web distribution, RTMP distribution)
    c. Step 3: Use distribution domain name to access your content
    d. Step 4: (optional) Use your own domain name to access your content
How ever, I will show you how to use cloudfront with S3 and web server (For learning purpose only, and I will use free tier account to do this lab. Also, I will take many snapshots to show how to deal with it)

3. how to deploy cloudfront
a. Create S3 bucket
- Go to S3 service and create your own bucket (Remember to check "Block all public access" in the permission section)
- Upload your content to S3 bucket (I will upload a simple index.html file to test) - Suppose that we have a full webserver with many html, css, js and image files, we could have some folders to organize them. - More efficiency.
- Set permission for your S3 bucket (You can use bucket policy to set permission for your S3 bucket)
- Go to the permission section of your S3 bucket and edit the bucket policy to make your bucket public (You can use the policy generator to create your own policy)
- Go to the properties section of your S3 bucket and enable static website hosting (You can use the index.html file as the index document)
- Copy the endpoint link of your S3 bucket (You will use this link to create your cloudfront distribution)

b. Create cloudfront distribution
- Go to Cloudfront service and create your own distribution
- Choose the web distribution and click on the get started button
- Don't forget to tick on the "Restrict Bucket Access" option and create a new identity to access your S3 bucket => This is very important to make your S3 bucket private and only allow cloudfront to access your S3 bucket (which was private when we tick "Block all public access" when creating S3 bucket)
- Paste the endpoint link of your S3 bucket to the origin domain name (You can choose the default settings for the other options)
- Click on the create distribution button and wait for the distribution to be deployed (This may take some time, usually around 15-20 minutes - quite so long but we have to wait lol)
- Copy the domain name of your cloudfront distribution (You will use this link to access your content)
c. Access your content
- Paste the domain name of your cloudfront distribution to your browser and you will see your content is served through cloudfront (You can also use the endpoint link of your S3 bucket to access your content, but it will be slower than using cloudfront)
- You can also use the AWS CLI to access your content - But I haven't tried this method yet, maybe in the future or when I've learned about CLI.

4. how to use cloudfront with S3
- This method is very simple and easy to use, but it has some limitations. For example, you cannot use your own domain name to access your content, and you cannot use HTTPS to access your content (You can only use HTTP). But this method is very useful for learning purpose and testing.
- To use cloudfront with S3, you just need to follow the steps above to create.

## II. Getting started wht a secure static website using S3, CloudFront, and Route 53
## III. Configure distribution
1. Understand how multi-tenant distributions work
- Multi-tenant distributions with settings that can be reused across multiple distributions tenant. 
- with setup like that, I have my own distribution setting and based on my content origin type. 

some advantages of multi-tenant distributions:
Reducing operational burden.

Reusable configurations for web admins and software providers to manage CloudFront distribution for multiple web applications that deliver content to end users.

Enhanced integrations with other AWS services to deliver automated certificate management, unified security controls, and hassle-free configuration control at scale.

Maintaining consistent resource patterns across your implementations. Define settings that must be shared and then specify customizations for settings to override.

Customizable origin and security settings to meet specific needs at the distribution tenant level.

Organize your distribution tenants into different tiers. For example, if some distribution tenants require Origin Shield and some do not, you can group distribution tenants into different multi-tenant distributions.

Sharing a common DNS configuration across multiple domains.

(
Giảm gánh nặng vận hành.

Cấu hình có thể tái sử dụng cho quản trị viên web và nhà cung cấp phần mềm để quản lý phân phối CloudFront cho nhiều ứng dụng web cung cấp nội dung cho người dùng cuối.

Tích hợp nâng cao với các dịch vụ AWS khác để cung cấp quản lý chứng chỉ tự động, kiểm soát bảo mật thống nhất và kiểm soát cấu hình dễ dàng ở quy mô lớn.

Duy trì các mẫu tài nguyên nhất quán trên các triển khai của bạn. Xác định các cài đặt phải được chia sẻ và sau đó chỉ định các tùy chỉnh cho các cài đặt cần ghi đè.

Cài đặt gốc và bảo mật có thể tùy chỉnh để đáp ứng các nhu cầu cụ thể ở cấp độ đối tượng thuê phân phối.

Tổ chức các đối tượng thuê phân phối của bạn thành các tầng khác nhau. Ví dụ: nếu một số đối tượng thuê phân phối yêu cầu Origin Shield và một số thì không, bạn có thể nhóm các đối tượng thuê phân phối thành các bản phân phối đa đối tượng thuê khác nhau.

Chia sẻ cấu hình DNS chung trên nhiều tên miền.
)

2. how does multi-tenant distributions work 
- if the standard contains all thing that a distributions have, then the multi-tenant distributions will have the same things but we can reuse them for many distributions, then we cusomize settings for my distribution tenant.
    + Overview:
        Multi-tenant distributions (MTD) would be the base setting for our distributions.
        Each distribution tenant (DT) would be a distribution that uses the MTD as the base setting and customize some settings for the DT.
        Each DT would have its own origin, cache behavior, and other settings that can be customized.
        More, DT have it own ssl certificate, domain name...
    + By default:
        Create a connection group. that group cointrol
    + when create one more distribution tenant:
        distribution tenant would be the front door and some how.
    + after something, we achaieved the own dns host to route traffic  to the distribution tenant.

Learning CloudFront: 18092025
Doing some lab:

## **Lab 1: Understand how sinngle tenant distributions work**

1. Create S3 bucket
Here I created one bucket:
- name: culaotime-cloudfront-single-tenant
- object ownnership: ACLs disabled
- block public access: block all public access
- bucket versioning: disabled
- all is for default settings.
![Create S3 bucket](/IT'S CU LAO TIME/CloudFront/Snapshot/Create_S3_bucket.png)

2. Upload content to S3 bucket (one single index.html file)
- Create one simple index.html file and upload to s3 bucket
![Upload content to S3 bucket](/IT'S CU LAO TIME/CloudFront/Snapshot/Update_index_file.png)

3. Set permission for S3 bucket (Make it private only)

4. Enable static website hosting for S3 bucket
nah that's something good to do
5. Create cloudfront distribution
6. Access content using cloudfront domain name
7. Access content using S3 bucket endpoint (to compare the speed)


**Note**: 
- Note 1: the outline 6. and 7. is for compare 2 methods, also make them very clear to understand
- Image markdown syntax: ![alt text](/Snapshot/image_name.png)


## 
Slime thing: deep dive to this shit (*cause I have no idea what is this)

1. First layer: distribution
- this called main container, which is covered by a dns looks like asdfasjdflas.cloudfront.net
- in the distribution contained:
    + origin
    + behavior ( mapping the request to the origin)
    + cache, priority or logging

2. Origin:  Data layer
- source of data:
    + s3 bucket (statics file)
    + EC2/ALB: app and something
    + API gateway or mediapackage (or over the aws)
- we can use more than one origin within the distribution

3. behavior
- each behavior could map for each cache policy, or origin request policy 
- THis will decide hthe long of cache, do sent query stri8ng/cookie/header or not

4. Cache and policy
- cache policy: how to control cloudfront cache (TTL, forward querystring, header, cookie...)
- origin request policy: control which request should forward to the origin (but only forward a suitable information - avoiding overweight)

5. Security:
- OAC (origin access control): or OAI: S3 key, to keep user not try to byass thed CloudFront.
- SSL/TLS cerrtificate - ACM: to a custom domains have HTTPS
- signed url/cookie: to restrict access to the content
- aws waf and shield: preventing ddos and malware request

6. Monitoring and logging
a. Monitoring with cloudwatch metrics
- we can use s3 sserver access loggin or s3 cloudtrail data event.
- then we can see:
    + PrincipalId (instead of user random) for cloudfront
    + Requester (ip address of the user) (which is use set in condition)
- If we see request from public ip user: then mean oac is not working good (then have some wrong policy)
cloudfront metrix have some thing:
    + 4xxErrorRate: the rate of 4xx error (403, 404...)
    + 5xxErrorRate: the rate of 5xx error (500, 502, 503...)
    + TotalErrorRate: the rate of all error (4xx and 5xx)
    + CacheHitRate: the rate of cache hit
    + CacheMissRate: the rate of cache miss
    + BytesDownloaded/BytesUploaded: the amount of data downloaded/uploaded
    + Requests: the number of requests
    + Latency: the time taken to serve a request

b. Logging with cloudfront:
- We can enable standard logs or real-time logs
- check those field:
    - sc-status (status code: 200, 403, 404, 500...)
    - x-edge-result-type (hit, miss, error...)
    - x-edge-detailed-result-type (more detail)
- if oac is working good, all the request comes to s3 all access the cloudfront, prevent the outbound request.


