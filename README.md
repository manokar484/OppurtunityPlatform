# OppurtunityPlatform
# Opportunity Platform --- Software Requirements Specification (SRS)

**Version:** 1.0\
**Document type:** Software Requirements Specification\
**Project:** Opportunity Platform

## 1. Project Overview

### 1.1 Purpose

The Opportunity Platform is a web/mobile application that connects
people or organizations who need work done with individuals who have
relevant skills and availability. Users can register as either a
**Hirer** or a **Service Provider**.

Service Providers create profiles describing their skills, experience,
location, compensation expectations, work preferences, and availability.
Hirers publish requirements, discover suitable people, and send hiring
requests.

### 1.2 Objectives

-   Provide a common platform for finding and hiring skilled people.
-   Allow individuals to showcase skills, experience, and availability.
-   Help hirers identify suitable candidates efficiently.
-   Support a transparent request, acceptance, and hiring workflow.
-   Enable communication between hirers and service providers.
-   Support freelance, temporary, part-time, and other work
    arrangements.

### 1.3 Scope

The initial platform includes account registration, profiles, skill
management, availability management, hiring posts, candidate search,
hiring requests, notifications, and administration.

Payments, AI recommendations, video interviews, and advanced analytics
are considered future enhancements.

## 2. User Roles

### 2.1 Hirer

An individual or organization that needs to hire one or more people.

### 2.2 Service Provider

An individual who registers skills and experience and publishes their
availability to receive work opportunities.

### 2.3 Administrator

A platform operator who manages users, skill categories, reports,
complaints, and platform activity.

## 3. Functional Requirements

### 3.1 Registration and Authentication

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-01                               The system shall allow users to
                                      register using an email address or
                                      mobile number.

  FR-02                               The system shall allow registered
                                      users to log in and log out.

  FR-03                               During registration, users shall
                                      select an account type: Hirer or
                                      Service Provider.

  FR-04                               The system shall provide a
                                      password-reset process.

  FR-05                               Users shall be able to view and
                                      update their account information.

  FR-06                               The system shall support account
                                      deactivation.
  -----------------------------------------------------------------------

### 3.2 Service Provider Profile

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-07                               Service Providers shall be able to
                                      create and edit a profile.

  FR-08                               A profile shall support a name,
                                      profile photo, short biography, and
                                      contact preferences.

  FR-09                               Service Providers shall be able to
                                      add multiple skills.

  FR-10                               For each skill, Service Providers
                                      shall be able to specify
                                      proficiency and experience.

  FR-11                               Service Providers shall be able to
                                      add qualifications, certificates,
                                      and portfolio links or files.

  FR-12                               Service Providers shall be able to
                                      specify expected compensation, such
                                      as hourly, daily, or project-based
                                      rates.

  FR-13                               Service Providers shall be able to
                                      specify their location and
                                      preferred work mode (remote,
                                      on-site, or hybrid).

  FR-14                               Service Providers shall be able to
                                      set their profile visibility.
  -----------------------------------------------------------------------

### 3.3 Skills Management

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-15                               The system shall maintain a
                                      searchable list of skill
                                      categories.

  FR-16                               Service Providers shall be able to
                                      select one or more skills from the
                                      list.

  FR-17                               The system shall allow
                                      administrators to add, update, or
                                      deactivate skill categories.

  FR-18                               The system should support searching
                                      for skills by name or category.
  -----------------------------------------------------------------------

### 3.4 Availability Management

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-19                               Service Providers shall be able to
                                      set their general availability
                                      status (available, unavailable, or
                                      limited availability).

  FR-20                               Service Providers shall be able to
                                      add specific available dates and
                                      time slots.

  FR-21                               Service Providers shall be able to
                                      define recurring availability, such
                                      as selected weekdays and time
                                      ranges.

  FR-22                               Service Providers shall be able to
                                      update or remove availability
                                      slots.

  FR-23                               Hirers shall be able to filter
                                      Service Providers by availability.

  FR-24                               The system shall prevent or flag
                                      overlapping confirmed work
                                      commitments where scheduling
                                      information is available.
  -----------------------------------------------------------------------

### 3.5 Hiring Posts

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-25                               Hirers shall be able to create,
                                      edit, publish, pause, and close
                                      hiring posts.

  FR-26                               A hiring post shall include a title
                                      and description.

  FR-27                               Hirers shall be able to specify one
                                      or more required skills.

  FR-28                               Hirers shall be able to specify the
                                      number of people required.

  FR-29                               Hirers shall be able to specify
                                      experience or qualification
                                      requirements.

  FR-30                               Hirers shall be able to specify the
                                      work location and work mode.

  FR-31                               Hirers shall be able to specify the
                                      work schedule, start date, and
                                      expected duration.

  FR-32                               Hirers shall be able to specify a
                                      budget or compensation range.

  FR-33                               Hirers shall be able to view and
                                      manage responses to their hiring
                                      posts.
  -----------------------------------------------------------------------

### 3.6 Candidate Search and Matching

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-34                               Hirers shall be able to search
                                      Service Provider profiles by skill.

  FR-35                               Hirers shall be able to filter
                                      results by experience, location,
                                      work mode, availability, and
                                      expected compensation.

  FR-36                               Hirers shall be able to view
                                      Service Provider profiles according
                                      to the profile's visibility
                                      settings.

  FR-37                               The system should rank results by
                                      relevance to the hiring
                                      requirements.

  FR-38                               The system should identify which
                                      required skills and availability
                                      conditions match a candidate's
                                      profile.
  -----------------------------------------------------------------------

**Optional initial matching weights (configurable):**

-   Skills match: 40%
-   Availability match: 25%
-   Experience match: 20%
-   Budget match: 10%
-   Location/work-mode match: 5%

These weights are proposed starting values and should be validated with
product usage.

### 3.7 Hiring Requests and Applications

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-39                               Hirers shall be able to send a
                                      direct hiring invitation to a
                                      Service Provider.

  FR-40                               Service Providers shall be able to
                                      accept or reject an invitation.

  FR-41                               Service Providers shall be able to
                                      apply to suitable hiring posts.

  FR-42                               Hirers shall be able to review and
                                      accept or reject applications.

  FR-43                               Both parties shall be able to view
                                      the status of a hiring request or
                                      application.

  FR-44                               The system shall record important
                                      status changes with timestamps.

  FR-45                               Users shall be able to withdraw an
                                      application or cancel a request,
                                      subject to the agreed workflow.

  FR-46                               The system shall prevent duplicate
                                      active requests for the same post
                                      and provider.
  -----------------------------------------------------------------------

Suggested statuses: `Pending`, `Accepted`, `Rejected`, `Withdrawn`,
`Cancelled`, `In Progress`, and `Completed`.

### 3.8 Communication and Notifications

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-47                               The system should provide
                                      in-platform messaging between
                                      Hirers and Service Providers when
                                      permitted by the request workflow.

  FR-48                               The system shall notify users about
                                      new hiring requests and
                                      applications.

  FR-49                               The system shall notify users when
                                      a request or application is
                                      accepted, rejected, withdrawn, or
                                      cancelled.

  FR-50                               Users shall be able to manage
                                      notification preferences.
  -----------------------------------------------------------------------

### 3.9 Reviews and Reports

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-51                               After a confirmed engagement is
                                      completed, users may submit a
                                      rating and review.

  FR-52                               Users shall be able to report
                                      suspicious profiles, posts, or
                                      messages.

  FR-53                               The system shall allow
                                      administrators to review reports
                                      and take appropriate action.
  -----------------------------------------------------------------------

### 3.10 Administration

  -----------------------------------------------------------------------
  ID                                  Requirement
  ----------------------------------- -----------------------------------
  FR-54                               Administrators shall be able to
                                      view and manage registered
                                      accounts.

  FR-55                               Administrators shall be able to
                                      suspend or deactivate accounts that
                                      violate platform rules.

  FR-56                               Administrators shall be able to
                                      manage skill categories.

  FR-57                               Administrators shall be able to
                                      review reported content and
                                      complaints.

  FR-58                               Administrators should be able to
                                      view basic platform usage
                                      statistics.
  -----------------------------------------------------------------------

## 4. Non-Functional Requirements

  -----------------------------------------------------------------------
  Category                            Requirement
  ----------------------------------- -----------------------------------
  Performance                         Common pages and search results
                                      should load within 3 seconds under
                                      normal operating conditions.

  Security                            Passwords must be stored using a
                                      strong, salted password-hashing
                                      algorithm.

  Authorization                       Users may access only the functions
                                      and data permitted by their role
                                      and permissions.

  Privacy                             Contact and personal information
                                      shall be disclosed only according
                                      to user settings, consent, and
                                      applicable law.

  Scalability                         The architecture should support
                                      growth in users, profiles, posts,
                                      and requests.

  Availability                        The initial service availability
                                      target is 99.5%, excluding planned
                                      maintenance.

  Usability                           The interface should be responsive
                                      and usable on desktop and mobile
                                      devices.

  Reliability                         The system should handle repeated
                                      submissions safely and avoid
                                      duplicate requests.

  Maintainability                     The application should use modular
                                      components and documented APIs.

  Compatibility                       The web application should support
                                      current major browsers.

  Backup and Recovery                 The database and essential user
                                      data should be backed up regularly,
                                      with a documented recovery process.
  -----------------------------------------------------------------------

## 5. Main Application Workflows

### 5.1 Service Provider Workflow

1.  Register and select the Service Provider role.
2.  Complete the profile.
3.  Add skills, proficiency, and experience.
4.  Add location, work preferences, and expected compensation.
5.  Set general availability and specific time slots.
6.  Publish the profile.
7.  Receive direct invitations and/or discover hiring posts.
8.  Accept, reject, or apply for opportunities.
9.  Communicate with the Hirer and confirm the engagement.
10. Update availability as work commitments change.

### 5.2 Hirer Workflow

1.  Register and select the Hirer role.
2.  Complete the hirer or organization profile.
3.  Create and publish a hiring post.
4.  Specify required skills, schedule, location, duration, and budget.
5.  Search and filter Service Providers.
6.  Review profiles and availability.
7.  Send direct invitations and/or review applications.
8.  Accept a suitable person and confirm the engagement.
9.  Communicate with the Service Provider.
10. Mark the engagement as completed and optionally leave a review.

### 5.3 High-Level Workflow Diagram

``` mermaid
flowchart TD
    A[Register / Log In] --> B{Select Account Type}
    B -->|Hirer| C[Create Hiring Post]
    B -->|Service Provider| D[Create Profile]
    D --> E[Add Skills and Experience]
    E --> F[Set Availability]
    C --> G[Search / Receive Applications]
    F --> H[Discover Opportunities / Receive Invitations]
    G --> I[Review Service Provider]
    H --> J[Review Hiring Requirement]
    I --> K[Send Hiring Request]
    J --> L[Apply for Opportunity]
    K --> M{Provider Decision}
    L --> N{Hirer Decision}
    M -->|Accept| O[Confirm Engagement]
    N -->|Accept| O
    M -->|Reject| P[Close Request]
    N -->|Reject| P
    O --> Q[Work In Progress]
    Q --> R[Mark Completed]
```

## 6. Database Requirements

The following tables are proposed for the initial relational database
design.

  -----------------------------------------------------------------------
  Table                               Important fields
  ----------------------------------- -----------------------------------
  `users`                             user_id, name, email, phone,
                                      password_hash, role,
                                      account_status, created_at

  `hirer_profiles`                    hirer_profile_id, user_id,
                                      organization_name, description,
                                      location

  `provider_profiles`                 provider_profile_id, user_id,
                                      biography, experience_years,
                                      location, work_mode, expected_rate

  `skills`                            skill_id, skill_name, category_id,
                                      status

  `skill_categories`                  category_id, category_name

  `provider_skills`                   provider_skill_id,
                                      provider_profile_id, skill_id,
                                      proficiency, experience_years

  `provider_availability`             availability_id,
                                      provider_profile_id, date,
                                      start_time, end_time,
                                      recurrence_rule, status

  `hiring_posts`                      post_id, hirer_id, title,
                                      description, location, work_mode,
                                      budget_min, budget_max, start_date,
                                      duration, status

  `required_skills`                   post_id, skill_id,
                                      minimum_proficiency

  `hiring_requests`                   request_id, post_id,
                                      provider_profile_id, request_type,
                                      status, created_at, updated_at

  `messages`                          message_id, conversation_id,
                                      sender_id, message_text, sent_at

  `conversations`                     conversation_id, created_at

  `reviews`                           review_id, engagement_id,
                                      reviewer_id, reviewed_user_id,
                                      rating, comments

  `reports`                           report_id, reporter_id,
                                      reported_user_id, reason, status,
                                      created_at

  `notifications`                     notification_id, user_id, type,
                                      content, read_at, created_at
  -----------------------------------------------------------------------

### 6.1 Key Relationships

-   One user has one account role and may have a corresponding Hirer or
    Service Provider profile.
-   One Service Provider can have multiple skills.
-   One skill can belong to many Service Providers.
-   One Service Provider can define multiple availability slots.
-   One Hirer can create multiple hiring posts.
-   One hiring post can require multiple skills.
-   One hiring post can receive applications or invitations from
    multiple Service Providers.
-   Hiring requests connect a hiring post with a Service Provider.
-   Reviews should be linked to a completed engagement.

## 7. Suggested Technology Stack

  -----------------------------------------------------------------------
  Layer                               Suggested technology
  ----------------------------------- -----------------------------------
  Web frontend                        React.js

  Mobile application (optional)       React Native

  Backend                             Node.js with Express.js

  Database                            PostgreSQL

  Authentication                      Secure sessions or JWT with
                                      appropriate refresh-token handling

  Real-time messaging                 Socket.IO or a managed messaging
                                      service

  File storage                        AWS S3 or equivalent object storage

  Hosting                             AWS, Azure, or another cloud
                                      provider

  API style                           REST API (initial recommendation)
  -----------------------------------------------------------------------

Technology choices are recommendations and may be changed based on the
development team's skills and deployment requirements.

## 8. MVP --- First Release

The first release should focus on the smallest complete hiring workflow.

### Must-have features

-   User registration and login.
-   Hirer and Service Provider roles.
-   Service Provider profile creation.
-   Skill registration and experience details.
-   Availability management.
-   Hirer profile and hiring post creation.
-   Candidate search and basic filters.
-   Direct hiring requests and/or applications.
-   Accept/reject request workflow.
-   Basic notifications.
-   Admin account and skill-category management.

### Defer until later releases

-   AI-based recommendations.
-   Resume parsing and automatic skill extraction.
-   Online payments and platform commissions.
-   Video interviews.
-   Advanced identity and skill verification.
-   Advanced ratings and analytics.
-   Calendar integrations.

## 9. Assumptions and Constraints

-   Users are responsible for keeping their skills and availability
    information accurate.
-   A Service Provider's availability does not guarantee that the person
    will accept a request.
-   A hiring request becomes a confirmed engagement only after the
    required parties accept the terms.
-   The platform should clearly distinguish a hiring invitation from an
    application to a public hiring post.
-   Payment processing is outside the initial MVP unless explicitly
    added to scope.
-   The platform must follow applicable privacy, employment,
    consumer-protection, and data-protection requirements in its
    operating regions.

## 10. Acceptance Criteria for the MVP

The MVP can be considered ready for initial release when:

1.  A user can register and log in as either a Hirer or Service
    Provider.
2.  A Service Provider can create a profile, add multiple skills, and
    set availability.
3.  A Hirer can create and publish a hiring post with required skills
    and schedule details.
4.  A Hirer can search and filter Service Providers.
5.  A Hirer can send an invitation to a Service Provider.
6.  A Service Provider can accept or reject an invitation.
7.  A Service Provider can apply to a hiring post and the Hirer can
    review the application.
8.  Both parties can see the correct request or application status.
9.  Users receive notifications for important status changes.
10. Administrators can manage accounts and review reports.

------------------------------------------------------------------------

**End of document**
