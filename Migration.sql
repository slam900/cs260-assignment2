-- 1: # of features in Wyoming
SELECT
  COUNT(*)
FROM
  wy_feature f
  JOIN wy_location l ON f.location_id = l.location_id
  JOIN wy_county c ON l.county_id = c.county_id
  JOIN wy_state s ON c.state_id = s.state_id
WHERE
  state_alpha = 'WY';
-- 2: Name & elevation of feature in Wyoming with highest elevation
SELECT
  MAX(elevation_m)


ORDER BY
  elevation_m